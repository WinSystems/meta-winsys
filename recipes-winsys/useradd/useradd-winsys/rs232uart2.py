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
config_output.consumer = "RS232UART2"
config_output.request_type = gpiod.line_request.DIRECTION_OUTPUT


gpio80.request(config_output, 0)
gpio81.request(config_output, 0)
gpio82.request(config_output, 0)

#Set GPIO values
gpio80.set_value(0) #RS485 EN
gpio81.set_value(0) #Full Duplex
gpio82.set_value(0) #RE