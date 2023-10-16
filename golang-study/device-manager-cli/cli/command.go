package cli

import (
	"gopkg.in/ukautz/clif.v1"
)

func CreateCommand() *clif.Command {
	return clif.NewCommand("create", "Command to create a new device", CallbackCreate).
		AddOption(NicknameOption()).
		AddOption(OwnerOption()).
		AddOption(IpOption())
}

func UpdateCommand() *clif.Command {
	return clif.NewCommand("update", "Command to update an existing device", CallbackUpdate).
		AddOption(IdOption()).
		AddOption(NicknameOption()).
		AddOption(OwnerOption()).
		AddOption(IpOption())
}

func DeleteCommand() *clif.Command {
	return clif.NewCommand("delete", "Command to delete an existing device", CallbackDelete).
		AddOption(IdOption())
}

func RetrieveCommand() *clif.Command {
	return clif.NewCommand("get", "Command to retrieve an existing device", CallbackRetrieve).
		AddOption(IdOption())
}

func ListCommand() *clif.Command {
	return clif.NewCommand("list", "Command to retrieve an existing device", CallbackList)
}
