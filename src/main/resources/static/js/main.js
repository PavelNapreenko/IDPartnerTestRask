const ratesApi = Vue.resource('/rates');

Vue.component('rate-row', {
    props: ['rate'],
    template:
        '<div><i>{{ rate.name }}</i>, {{ rate.rate }}, {{ rate.date }}, {{ rate.time }}' +
        '</div>'
});

Vue.component('rates-list', {
    props: ['rates'],
    template:
        '<div>' +
            '<rate-row v-for="rate in rates" :rate="rate" />' +
        '</div>',
    created: function (){
        ratesApi.get().then(result =>
            result.json().then(data =>
                data.forEach(rate => this.rates.push(rate))
            )
        )
    }
});

const app = new Vue({
    el: '#app',
    template: '<rates-list :rates="rates" />',
    data: {
        rates: []
    }
});