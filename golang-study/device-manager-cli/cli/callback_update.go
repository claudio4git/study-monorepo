package cli

import (
	"fmt"
	"github.com/go-resty/resty/v2"
	"gopkg.in/ukautz/clif.v1"
)

func CallbackUpdate(c *clif.Command) {
	id := c.Option("id").String()
	nickname := c.Option("nickname").String()
	owner := c.Option("owner").String()
	ip := c.Option("ip").String()
	_ = c.Option("ip").String()

	client := resty.New()

	_, err := client.R().
		EnableTrace().
		SetHeader("Content-Type", "application/json").
		SetBody(DeviceDto{
			Nickname: nickname,
			Owner:    owner,
			Ip:       ip,
		}).
		SetPathParams(map[string]string{
			"deviceId": id,
		}).
		Put("http://localhost:8000/device/{deviceId}")

	if err != nil {
		fmt.Println("Error: ", err)
		return
	}

	fmt.Println("Updated successful")
}
