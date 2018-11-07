import axios from 'axios';

export default {
    saveEvent: (data) => axios({ url: "/events",  method: "post", data}),
    getEvents: () => axios(`/events`)
}