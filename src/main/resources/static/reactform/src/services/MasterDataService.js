export default class MasterDataService{
    
    constructor(){
        this.url = `${window.location.protocol + '//' + window.location.host}`;
    }

    fetchMasterData(type, callback){
        fetch(`${this.url}/api/master-data/${type}`, {
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

    fetchDecisionType(){
        return [
            {
                value: "Y",
                label: "Yes"
            },
            {
                value: "N",
                label: "No"
            },
        ]
    }

    fetchCustomerType(callback){
        this.fetchMasterData('customer-types', callback);
    }

    fetchLoanType(callback){
        this.fetchMasterData('loan-types', callback);
    }
}