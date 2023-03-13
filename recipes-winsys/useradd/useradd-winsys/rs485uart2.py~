import subprocess
import gpiod
import sys
import time

# Get GPIO0 Bank/gpiochip0
chip=gpiod.chip('gpiochip2')

# Get gpiochip0 bank lines
gpio80 = chip.get_line(16)
gpio81 = chip.get_line(17)
gpio82 = chip.get_line(18)

# Create Output config
config_output = gpiod.line_request()
config_output.consumer = "RS485UART2"
config_output.request_type = gpiod.line_request.DIRECTION_OUTPUT


gpio80 = chip.request(config_output, 0)
gpio81 = chip.request(config_output, 0)
gpio82 = chip.request(config_output, 0)

#Set GPIO values
gpio80.set_value(1)
gpio81.set_value(1)
gpio82.set_value(0)

subprocess.call(['./rs485-config 2'])

# Old legacy bash script64
# echo 80 > /sys/class/gpio/export
# echo 81 > /sys/class/gpio/export
# echo 82 > /sys/class/gpio/export
# echo out > /sys/class/gpio/gpio80/direction
# echo out > /sys/class/gpio/gpio81/direction
# echo out > /sys/class/gpio/gpio82/direction
# echo 1 > /sys/class/gpio/gpio80/value
# echo 1 > /sys/class/gpio/gpio81/value
# echo 0 > /sys/class/gpio/gpio82/value

# ./rs485-config 2
