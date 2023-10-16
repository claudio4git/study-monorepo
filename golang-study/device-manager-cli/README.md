# Project
> Device manager to practice Golang.

# Technologies
- resty (Rest client)
- clif (Command line client)

# Build
- Build and generate bin file `go build -o dmc cmd/device_manager_cli.go`

# Client commands
- Create a new device `./dmc create -d <nickname> -o <owner> -i <ip>`
- Update an existing device `./dmc update --id <device id> -d <new nickname> -o <new owner> -i <new ip>`
- Delete an existing device `./dmc get --id <device id>`
- List all devices `./dmc list`
