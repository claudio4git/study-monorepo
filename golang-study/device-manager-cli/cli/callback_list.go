package cli

import (
	"bytes"
	"encoding/json"
	"fmt"
	"github.com/go-resty/resty/v2"
	"gopkg.in/ukautz/clif.v1"
)

func CallbackList(_ *clif.Command) {
	client := resty.New()

	resp, err := client.R().
		EnableTrace().
		SetHeader("Content-Type", "application/json").
		Get("http://localhost:8000/device?page=0&size=10")

	if err != nil {
		fmt.Println("Error: ", err)
		return
	}

	var devicePageable = DevicePageable{}
	reader := bytes.NewReader(resp.Body())
	_ = json.NewDecoder(reader).Decode(&devicePageable)

	for _, device := range devicePageable.Devices {
		fmt.Println("Id......: ", device.Id)
		fmt.Println("Nickname: ", device.Nickname)
		fmt.Println("Owner...: ", device.Owner)
		fmt.Println("Ip......: ", device.Ip)
		fmt.Println("")
	}

}
