/**
 * fetch getMethod (csrf 포함)
 * async , await 필요
 * @param url api 주소(String)
 * @param params data
 * @param pageYn data - true 이면 url 에 있는 자바객체 pageable 정보들을 가져온다
 * spring boot parameter 개별 - @RequestParam(생략) ,
 * spring boot parameter 객체 - @ModelAttribute(생략)
 */
async function fetchGet(url , params) {
    try {
        if (params) {
            url += '?' + getQueryString(params);
        }

        const response = await fetch(url, {
            method: 'GET',
            headers: {'X-XSRF-TOKEN': getCsrfToken()},
        });

        if (!response.ok) {
            const errorResponse = await response.json();
            alert(errorResponse.message);
            throw new Error(`Error: ${errorResponse.message}`);
        }

        const apiResponse = await response.json();
        return apiResponse.data;
    } catch (error) {
        console.error('Fetch error:', error);
        throw error; // 필요시 에러 다시 던지기
    }

}

/**
 * fetch postMethod (csrf 포함)
 * @param url api 주소(String)
 * @param jsonData Json
 * @async
 * spring boot parameter 개별 - @RequestBody(생략)
 * spring boot parameter 개별 - @RequestBody(생략)
 * 객체안에 객 const json = {
 *                 name: 'test',
 *                 age: ['19', '20'],
 *                 testdto2: {
 *                     name: 'subTest',
 *                     age: ['25', '30']
 *                 }
 *             };
 * */
async function fetchPostByJson(url, jsonData) {
    try {
        const response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "X-XSRF-TOKEN": getCsrfToken(), // CSRF 토큰 추가
            },
            body: JSON.stringify(jsonData),
        });

        if (!response.ok) {
            const errorResponse = await response.json();
            alert(errorResponse.message);
            throw new Error(`Error: ${errorResponse.message}`);
        }

        const apiResponse = await response.json();
        return apiResponse.data;
    } catch (error) {
        throw error;
    }
}

/**
 * fetch postMethod (csrf 포함)
 * @param url api 주소(String)
 * @param formData formData
 * @async
 * spring boot parameter 개별 - @RequestParam(생략)
 * spring boot parameter 개별 - @ModelAttribute(생략)
 * 객체안에 객체 input name="testdto2.age" -> testdto2.객체 안에 age 값 , list는 append 반복
 * */
async function fetchPostByFormData(url, formData) {
    try {
        const response = await fetch(url, {
            method: "POST",
            headers: {'X-XSRF-TOKEN': getCsrfToken()},
            body: formData,
        });

        if (!response.ok) {
            const errorResponse = await response.json();
            alert(errorResponse.message);
            throw new Error(`Error: ${errorResponse.message}`);
        }

        const apiResponse = await response.json();
        return apiResponse.data;

    } catch (error) {
        throw error;
    }
}

/**
 * fetch patchMethod (csrf 포함)
 * @param url api 주소(String)
 * @param jsonData Json(객체) , FormData
 * @async
 * @example @RequestBody
 */
async function fetchPatchByJson(url, jsonData) {
    try {
        const response = await fetch(url, {
            method: "PATCH",
            headers: {
                "Content-Type": "application/json",
                "X-XSRF-TOKEN": getCsrfToken(), // CSRF 토큰 추가
            },
            body: JSON.stringify(jsonData),
        });

        if (!response.ok) {
            const errorResponse = await response.json();
            alert(errorResponse.message);
            throw new Error(`Error: ${errorResponse.message}`);
        }

        const apiResponse = await response.json();
        return apiResponse.data;

    } catch (error) {
        throw error;
    }
}


/**
 * fetch patchMethod (csrf 포함)
 * @param url api 주소(String)
 * @param formData Json(객체) , FormData
 * @async
 * @example @RequestBody
 */
async function fetchPatchByFormData(url, formData) {

    try {
        const response = await fetch(url, {
            method: "PATCH",
            headers: {'X-XSRF-TOKEN': getCsrfToken()},
            body: formData,
        });

        if (!response.ok) {
            const errorResponse = await response.json();
            alert(errorResponse.message);
            throw new Error(`Error: ${errorResponse.message}`);
        }

        const apiResponse = await response.json();
        return apiResponse.data;

    } catch (error) {
        throw error;
    }
}

async function fetchGetWithoutCsrf(url, params = {}) {
    try {
        // 쿼리 파라미터 추가
        if (Object.keys(params).length > 0) {
            const queryString = new URLSearchParams(params).toString();
            url += `?${queryString}`;
        }

        // API 요청
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });

        // 응답 확인
        if (!response.ok) {
            const errorResponse = await response.json();
            throw new Error(`API Error: ${errorResponse.message || response.statusText}`);
        }

        return await response.json(); // API 응답을 JSON으로 반환
    } catch (error) {
        console.error('fetchGetExternal Error:', error);
        throw error;
    }
}


/**
 * fetch delete
 * @param url api 주소(String)
 * @async
 */
async function fetchDelete(url) {
    try {
        const response = await fetch(url, {
            method: "DELETE",
            headers: {'X-XSRF-TOKEN': getCsrfToken()},
        });

        if (!response.ok) {
            alert(await response.text());
            throw new Error("API 오류");
        }

        if (!response.ok) {
            const errorResponse = await response.json();
            alert(errorResponse.message);
            throw new Error(`Error: ${errorResponse.message}`);
        }

        const apiResponse = await response.json();
        return apiResponse.data;
    } catch (error) {
        throw error;
    }
}

async function fetchPostByLogout(url) {
    try {
        const csrfToken = getCsrfToken();
        const response = await fetch(url, {
            method: "POST",
            credentials: "include",
            headers: {
                "X-XSRF-TOKEN": csrfToken,
                "Content-Type": "application/json"
            }
        });

        if (!(response.ok || response.status === 302)) {
            throw new Error(`로그아웃 실패 - 상태 코드: ${response.status}`);
        }

    } catch (error) {
        console.error("Logout failed:", error);
        alert("로그아웃에 실패하였습니다. 다시 시도해주세요.");
    }
}




/**
 * url에 queryString 추가해서 변경해준다.
 * @example localhost/admin?id=1&type=2
 * @param params json(객체) , FormData
 */
function changeUrl(params) {
    let queryString = '';
    queryString = '?' + getQueryString(params);
    const uriToChange = location.pathname + queryString;
    history.replaceState(null, '', uriToChange);
}

function changePageInput(pageNo) {
    if (pageNo !== undefined) {
        document.querySelector('input[name=page]').value = pageNo;
    }
}

/**
 * Json , FormData를 QueryString 문자열로 변경해준다.
 * @example ?id=1&type=2
 * @param params json(객체) , FormData
 */
function getQueryString(params) {
    if (params instanceof FormData) {
        return Array.from(params.entries())
            .map(entry => `${encodeURIComponent(entry[0])}=${encodeURIComponent(entry[1])}`)
            .join('&');
    } else {
        return Object.keys(params)
            .map(key => encodeURIComponent(key) + '=' + encodeURIComponent(params[key]))
            .join('&');
    }
}


/**
 * FormData 를 key : value 형태로 print
 * @param formData FormData
 */
function logFormData(formData) {
    formData.forEach((value, key) => {
        console.log(`${key} : ${value}`)
    })
}

/**
 * 엘리먼트 조회
 * @example find('input[name=type]');
 * @param selector Selectors
 * @returns Element
 */
function find(selector) {
    return document.querySelector(selector);
}

function findAll(selector) {
    return document.querySelectorAll(selector);
}

/**
 * FormData 를 Json으로 리턴해준다.
 * @param params FormData
 */
function changeFormDataToJson(formData) {
    const json = {};
    for (const [key, value] of formData.entries()) {
        json[key] = value;
    }
    return json;
}

/**
 * url query string 의 value를 가져와주는 메소드
 * @param {name} value가 필요한 queryString 이름
 */
function getParamValue(name) {
    return new URLSearchParams(window.location.search).get(name);
}

/**
 * json 데이터의 key 와 매칭되는 name을 갖고있는 elem을 찾아 value를 넣어준다.
 */
function drawByName(response) {
    Object.keys(response).forEach(key => {
        const inputElement = document.querySelector(`input[name="${key}"]`);
        if (inputElement) {
            inputElement.value = response[key];
        }
    });
}

/**
 * 클래스 이름이 같은 엘리먼트의 textContent에 해당 키의 값을 넣는다.
 * @param {object} response - JSON 데이터
 */
function drawByClass(response) {
    Object.keys(response).forEach(key => {
        const elements = document.querySelectorAll(`.${key}`);
        if (elements.length > 0) {
            elements.forEach(element => {
                element.textContent = response[key];
            });
        }
    });
}


/**
 * 클래스 이름이 같은 엘리먼트의 textContent에 해당 키의 값을 넣는다.
 * @param {object} response - JSON 데이터
 */
function drawByClassToDecode(response) {
    Object.keys(response).forEach(key => {
        const elements = document.querySelectorAll(`.${key}`);
        if (elements.length > 0) {
            elements.forEach(element => {
                element.textContent = decodeHTML(response[key]);
            });
        }
    });
}

/**
 * empty => 빈문자열로 변환
 * @param data String
 */
function isEmpty(data) {
    if (data === null || data === "" || data === "null" || data === undefined || data === "undefined") {
        return "";
    }
    return data
}


function nullCheck(value) {
    return (value === null || value === 'null' || value === '') ? '' : value;
}

function nullReturn(value) {
    return (value === null || value === 'null' || value === '') ? '해당없음' : value;
}


function decodeHTML(text) {
    if (text === null || text === '' || text == undefined) {
        return '';
    }

    const textarea = document.createElement('textarea');
    textarea.innerHTML = text;
    return textarea.value;
}

/**
 * 주어진 정규식 패턴에 따라 입력된 값이 유효한지 확인하는 함수
 * @param {String} value 확인할 값
 * @param {RegExp} pattern 정규식 패턴
 * @param {String} fieldName 필드 이름 (예: "아이디", "비밀번호")
 * @returns {String} 유효하지 않은 경우 오류 메시지, 유효한 경우 null
 */
function validRegex(value, pattern, message) {
    if (!pattern.test(value)) {
        alert(message);
        throw new Error(message);
    }
    return null;
}

function validNull(value, message) {
    if(nullCheck(value) === ''){
        alert(message);
        throw new Error(message);
    }
    return null;
}

function getCsrfToken(){
    return document.cookie.split('; ')
        .find(row => row.startsWith('XSRF-TOKEN='))
        ?.split('=')[1];
}