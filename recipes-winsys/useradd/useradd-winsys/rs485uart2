#!/bin/bash

echo 80 > /sys/class/gpio/export
echo 81 > /sys/class/gpio/export
echo 82 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio80/direction
echo out > /sys/class/gpio/gpio81/direction
echo out > /sys/class/gpio/gpio82/direction
echo 1 > /sys/class/gpio/gpio80/value
echo 1 > /sys/class/gpio/gpio81/value
echo 0 > /sys/class/gpio/gpio82/value

./rs485-config 2
