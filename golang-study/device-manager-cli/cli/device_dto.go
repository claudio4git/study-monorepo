package cli

type DeviceDto struct {
	Nickname	string		`json:"nickname"`
	Owner		string		`json:"owner"`
	Ip			string		`json:"ip"`
	Id			string		`json:"id"`
}

type DevicePageable struct {
	Devices 	[]DeviceDto		`json:"devices"`
	Page 		int				`json:"page"`
	Size 		int				`json:"size"`
}
