package model

type Device struct {
	Base
	Nickname	string	`json:"nickname"`
	Owner		string	`json:"owner"`
	IP			string	`json:"ip"`
}

type DevicePageable struct {
	Devices 	*[]Device	`json:"devices"`
	Page 		int			`json:"page"`
	Size 		int			`json:"size"`
}