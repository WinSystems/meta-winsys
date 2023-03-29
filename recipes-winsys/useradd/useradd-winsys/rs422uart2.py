import subprocess
import gpiod
import sys
import time

subprocess.call(['dmesg', '-n', '1'])
subprocess.call(['systemctl', 'stop', 'serial-getty@ttymxc0.service'])

# Get GPIO0 Bank/gpiochip0
chip=gpiod.chip('gpiochip2')

# Get gpiochip0 bank lines
gpio73 = chip.get_line(9) #RS485 EN
gpio72 = chip.get_line(8) #Full Duplex
gpio71 = chip.get_line(7)

# Create Output config
config_output = gpiod.line_request()
config_output.consumer = "RS422UART1"
config_output.request_type = gpiod.line_request.DIRECTION_OUTPUT


gpio73.request(config_output, 0)
gpio72.request(config_output, 0)
gpio71.request(config_output, 0)

#Set GPIO values
gpio73.set_value(1) #RS485 EN
gpio72.set_value(0) #Full Duplex
gpio71.set_value(0) #RE

subprocess.call(['./rs485-config', '1', 'nostdout'])

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
