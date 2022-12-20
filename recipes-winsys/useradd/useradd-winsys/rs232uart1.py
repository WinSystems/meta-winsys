import subprocess
import gpiod
import sys
import time

# Get GPIO0 Bank/gpiochip0
chip=gpiod.chip('gpiochip2')

# Get gpiochip0 bank lines
gpio73 = chip.get_line(9) #RS485 EN
gpio72 = chip.get_line(8) #Full Duplex
gpio71 = chip.get_line(7)

# Create Output config
config_output = gpiod.line_request()
config_output.consumer = "RS232UART1"
config_output.request_type = gpiod.line_request.DIRECTION_OUTPUT


gpio73.request(config_output, 0)
gpio72.request(config_output, 0)
gpio71.request(config_output, 0)

#Set GPIO values
gpio73.set_value(0) #RS232 EN
gpio72.set_value(0) #Full Duplex
gpio71.set_value(0) #RE

# Old legacy bash script
# echo 73 > /sys/class/gpio/export
# echo 72 > /sys/class/gpio/export
# echo 71 > /sys/class/gpio/export
# echo out > /sys/class/gpio/gpio73/direction
# echo out > /sys/class/gpio/gpio72/direction
# echo out > /sys/class/gpio/gpio71/direction
# echo 1 > /sys/class/gpio/gpio73/value
# echo 0 > /sys/class/gpio/gpio72/value
# echo 0 > /sys/class/gpio/gpio71/value
