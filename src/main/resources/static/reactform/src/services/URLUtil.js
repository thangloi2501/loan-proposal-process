export default class URLUtil{

    getParameters = (url) => {
        const query = window.location.search
        let params = {};
        if(query){
            const paramString = query.substring(1, query.length);
            const pairs = paramString.split("&");
            pairs.forEach(item => {
                const tokens = item.split("=");
                params[tokens[0]] = tokens[1];
            });
        }
        return params;
    }
}