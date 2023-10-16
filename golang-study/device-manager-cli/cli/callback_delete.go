package cli

import (
	"fmt"
	"github.com/go-resty/resty/v2"
	"gopkg.in/ukautz/clif.v1"
)

func CallbackDelete(c *clif.Command) {
	id := c.Option("id").String()
	_ = c.Option("id").String()

	client := resty.New()

	_, err := client.R().
		EnableTrace().
		SetHeader("Content-Type", "application/json").
		SetPathParams(map[string]string{
			"deviceId": id,
		}).
		Delete("http://localhost:8000/device/{deviceId}")

	if err != nil {
		fmt.Println("Error: ", err)
		return
	}

	fmt.Println("Deleted successful")
}
