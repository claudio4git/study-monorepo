package cli

import (
	"bytes"
	"encoding/json"
	"fmt"
	"github.com/go-resty/resty/v2"
	"gopkg.in/ukautz/clif.v1"
)

func CallbackRetrieve(c *clif.Command) {
	id := c.Option("id").String()
	_ = c.Option("id").String()

	client := resty.New()

	resp, err := client.R().
		EnableTrace().
		SetHeader("Content-Type", "application/json").
		SetPathParams(map[string]string{
			"deviceId": id,
		}).
		Get("http://localhost:8000/device/{deviceId}")

	if err != nil {
		fmt.Println("Error: ", err)
		return
	}

	var device = DeviceDto{}
	reader := bytes.NewReader(resp.Body())
	_ = json.NewDecoder(reader).Decode(&device)

	fmt.Println("Id......: ", device.Id)
	fmt.Println("Nickname: ", device.Nickname)
	fmt.Println("Owner...: ", device.Owner)
	fmt.Println("Ip......: ", device.Ip)
}
