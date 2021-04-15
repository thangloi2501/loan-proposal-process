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

    fetchPositionType(){
        return [
            {
                value: "n",
                label: "New"
            },
            {
                value: "e",
                label: "Existing"
            },
        ]
    }

    fetchCustomerType(){
        this.fetchMasterData('customer-types', callback);
    }

    fetchLoanType(){
        this.fetchMasterData('loan-types', callback);
    }
}