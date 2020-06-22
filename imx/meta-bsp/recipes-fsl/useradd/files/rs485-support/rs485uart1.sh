#!/bin/bash
dmesg -n 1

systemctl stop serial-getty@ttymxc0.service

echo 73 > /sys/class/gpio/export
echo 72 > /sys/class/gpio/export
echo 71 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio73/direction
echo out > /sys/class/gpio/gpio72/direction
echo out > /sys/class/gpio/gpio71/direction
echo 1 > /sys/class/gpio/gpio73/value
echo 1 > /sys/class/gpio/gpio72/value
echo 0 > /sys/class/gpio/gpio71/value

./rs485-config 1
