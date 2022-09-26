module.exports = {
    async Headers() {
        return [
            {
                source: '/:path*',
                headers: [
                    { key: 'Access-Control-Allow-Credenciais', value:'true'},
                    { key: 'Access-Control-Allow-Origin', values:'http://localhost:8080/todos'},
                    { key: 'Access-Control-Allow-Methods', values:'*'},
                    { key: 'Access-Control-Allow-Headers', values:'*'},
                ]
            }
        ]
    }
}