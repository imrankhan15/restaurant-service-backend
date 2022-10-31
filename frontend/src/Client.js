import fetch from 'unfetch';



const checkStatus = response => {
    if (response.ok) {
        return response;
    }
    // convert non-2xx HTTP responses into errors:
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}



export const addNewGuest = guest =>
    fetch("api/v1/guests", {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(guest)
        }
    ).then(checkStatus)

export const addNewTable = guest =>
    fetch("api/v1/table-check", {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',

        }
    ).then(checkStatus)

export const checkTable = guestID =>
    fetch(`api/v1/table-check/${guestID}`, {
        method: 'DELETE'
    }).then(checkStatus);

export const getAllStudents = () =>
    fetch("api/v1/students")
        .then(checkStatus);

export const addNewStudent = student =>
    fetch("api/v1/students", {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(student)
        }
    ).then(checkStatus)

export const deleteStudent = studentId =>
    fetch(`api/v1/students/${studentId}`, {
        method: 'DELETE'
    }).then(checkStatus);