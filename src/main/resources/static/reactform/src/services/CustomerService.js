export default class CustomerService{
    
    constructor(){
        this.url = `${window.location.protocol + '//' + window.location.host}`;
    }

    getCustomerByCode(customerCode, callback){
        fetch(`${this.url}/api/customer/${customerCode}`, {
            method: 'GET',
        })
        .then(resp => resp.json())
        .then(
            
            (result) => {
                console.log("Fetched result: ", result)
                if(callback){
                    callback(result);
                }
            },

            (error) => {
                console.log(error);
                return [{value:"", label:"Error when fetching data"}];
            }
        );
    }
}