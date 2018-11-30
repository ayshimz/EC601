import React, { Component } from 'react';
import './App.css';
import Dropzone from 'react-dropzone'
import readXlsxFile from 'read-excel-file'
import {chatterPost} from "./database";


class App extends Component {
  onDrop = acceptedFiles => {
    acceptedFiles.forEach(file => {
      console.log(file)
      const reader = new FileReader();
      reader.onload = () => {
        readXlsxFile(file).then((rows) => {
          // `rows` is an array of rows
          // each row being an array of cells.
          console.log(rows)
          let rowName = rows[0]
          let rowData = rows.slice(1)
          let dataList = []
          rowData.forEach((r) => {
            let payload = {}
            let i
            for (i = 0; i < rowName.length; i++) {
              payload[rowName[i]] = r[i]
            }
            console.log(payload)
            dataList.push(payload)
          })
          console.log(dataList)
          let chatterData = {
            "type": "CLASSLIST",
            "userId": "instructor",
            "projectId": file,
            "data": JSON.stringify(dataList)
          }
          chatterPost(dataList)
        })

      };
      reader.onabort = () => console.log('file reading was aborted');
      reader.onerror = () => console.log('file reading has failed');
    });
  }

  render() {
    return (
      <div className="App">
        <Dropzone onDrop={this.onDrop}>
          {({ isDragActive, isDragReject }) => {
            if (isDragActive) {
              return "All files will be accepted";
            }
            if (isDragReject) {
              return "Some files will be rejected";
            }
            return "Dropping some files here...";
          }}
        </Dropzone>
      </div>
    );
  }
}

export default App;
