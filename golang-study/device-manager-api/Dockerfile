FROM golang:1.9 AS builder

ADD . /go/src/github.com/jclaudiocf/do-go/device-manager-api
WORKDIR /go/src/github.com/jclaudiocf/do-go/device-manager-api

CMD ["go", "run", "cmd/device_manager_api.go"]
