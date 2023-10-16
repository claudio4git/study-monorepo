package cli

import (
	"fmt"
	"github.com/go-resty/resty/v2"
	"gopkg.in/ukautz/clif.v1"
)

func CallbackCreate(c *clif.Command) {
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
		Post("http://localhost:8000/device")

	if err != nil {
		fmt.Println("Error: ", err)
		return
	}

	fmt.Println("Created successful")
}
