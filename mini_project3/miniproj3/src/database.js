import axios from 'axios'

export function chatterPost(data) {
  let newData = stringifyData(data)
  axios.post('http://localhost:8080/save', newData)
    .then((res) => {
      console.log(res)
    })
    .catch((e) => {
      console.log(e)
      console.log("error with post response")
    });
}

function stringifyData(data) {
  let keys = Object.keys(data)
  keys.forEach(k => {
    if (typeof data[k] !== "string") {
      let foo = data[k]
      data[k] = JSON.stringify(foo)
    }
  })
  return data
}