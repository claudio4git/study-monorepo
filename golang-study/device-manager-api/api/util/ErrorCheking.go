package util

import (
	"fmt"
	"net/http"
)

func ErrorChecking(err error, message string) {
	if err != nil {
		panic(fmt.Sprintf("fail to %s with detail: %s", message, err))
	}
}

func HttpErrorChecking(w http.ResponseWriter, err error, message string, httpErrorCode int) {
	if err != nil {
		var msg = fmt.Sprintf("fail to %s with detail: %s", message, err.Error())
		http.Error(w, msg, httpErrorCode)
		println(msg)
	}
}
