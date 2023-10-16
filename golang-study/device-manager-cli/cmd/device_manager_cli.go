package main

import (
	"github.com/jclaudiocf/do-go/device-manager-cli/cli"
	"gopkg.in/ukautz/clif.v1"
)

func main() {
	deviceManagerCli := clif.New("Device manager client", "0.0.1", "An application for manager devices")

	deviceManagerCli.Add(cli.CreateCommand(),
		cli.UpdateCommand(),
		cli.DeleteCommand(),
		cli.RetrieveCommand(),
		cli.ListCommand())

	deviceManagerCli.Run()
}
