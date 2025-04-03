name: Build and Deploy

on:
  push:
    branches: [main]

jobs:
  build-push-deploy:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Set up Docker Buildx
        uses: docker/setup-buildx-action@v2

      - name: DockerHub 로그인
        run: |
          echo "🔐 DockerHub 로그인 시작"
          echo "${{ secrets.DOCKER_TOKEN }}" | docker login -u "${{ secrets.DOCKER_USERNAME }}" --password-stdin
          echo "✅ DockerHub 로그인 완료"

      - name: Build and Push to DockerHub
        run: |
          echo "🔨 Docker 이미지 빌드 및 푸시 시작"
          docker buildx build --platform linux/amd64 \
            -t ${{ secrets.DOCKER_USERNAME }}/quiz-world:latest \
            --push .
          echo "✅ Docker 이미지 푸시 완료"

      - name: SSH 접속 후 서버에서 이미지 Pull 및 컨테이너 재시작
        run: |
          echo "🔧 sshpass 설치 및 서버 접속 준비"
          sudo apt-get update
          sudo apt-get install -y sshpass

          echo "🚀 서버에 SSH 접속하여 이미지 업데이트 및 재시작 수행"
          sshpass -p '${{ secrets.SSH_PASSWORD }}' ssh -o StrictHostKeyChecking=no ${{ secrets.SSH_USER }}@${{ secrets.SSH_HOST }} << 'EOF'
            echo "📦 기존 컨테이너 중지 및 삭제"
            docker stop quiz-world 2>/dev/null || true
            docker rm quiz-world 2>/dev/null || true

            echo "⬇️ Docker 이미지 pull"
            docker pull ${{ secrets.DOCKER_USERNAME }}/quiz-world:latest

            echo "🚀 컨테이너 실행"
            docker run -d -p 8080:8080 --name quiz-world ${{ secrets.DOCKER_USERNAME }}/quiz-world:latest

            echo "✅ 서버에서 배포 완료"
          EOF
