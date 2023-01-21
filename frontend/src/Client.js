import fetch from 'unfetch';



const checkStatus = response => {
    if (response.ok) {
        return response;
    }
    
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

export const addNewTable = table =>
    fetch("api1/v1/table-check", {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(table)
        }
    ).then(checkStatus)

export const checkTable = guestID =>
    fetch(`api1/v1/table-check/${guestID}`, {
        method: 'GET'
    }).then(checkStatus);

