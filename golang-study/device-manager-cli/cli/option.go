package cli

import (
	"gopkg.in/ukautz/clif.v1"
)

func NicknameOption() *clif.Option {
	return clif.NewOption("nickname", "d", "Device nickname", "", true, false)
}

func OwnerOption() *clif.Option {
	return clif.NewOption("owner", "o", "Device owner", "", true, false)
}

func IpOption() *clif.Option {
	return clif.NewOption("ip", "i", "Device IP", "", true, false)
}

func IdOption() *clif.Option {
	return clif.NewOption("id", "id", "Device IP", "", true, false)
}
