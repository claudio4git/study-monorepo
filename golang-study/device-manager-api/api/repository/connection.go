package repository

import (
	"github.com/jclaudiocf/do-go/device-manager-api/api/model"
	"github.com/jclaudiocf/do-go/device-manager-api/api/util"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/postgres"
)

func GetConnection() *gorm.DB {
	db, err := gorm.Open("postgres",
		"host=database-dm.c9tne3ttxrta.us-east-1.rds.amazonaws.com port=5432 user=postgres password=postgres-dm dbname=postgres sslmode=disable")

	util.ErrorChecking(err, "connect database")

	return db
}

func InitMigrations() {
	db := GetConnection()
	db.AutoMigrate(&model.Device{})
	defer db.Close()
}
