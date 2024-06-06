import subprocess
import gpiod
import sys
import time

# GPIO Banks are 0 indexed by the kernel: GPIO1 is Bank/gpiochip0
chip=gpiod.chip('gpiochip2')

# These are the GPIO lines connected to the UART2 transciever.
# MX8MQ_IOMUXC_NAND_DATA07_GPIO3_IO13     Serial SHDN
# MX8MQ_IOMUXC_NAND_DATA06_GPIO3_IO12     Serial SLEW
# MX8MQ_IOMUXC_NAND_DATA05_GPIO3_IO11     Serial FD_TX
# MX8MQ_IOMUXC_NAND_DATA04_GPIO3_IO10     Serial TERM
# MX8MQ_IOMUXC_NAND_DATA03_GPIO3_IO9      Serial MODE
# MX8MQ_IOMUXC_NAND_DATA02_GPIO3_IO8      Serial HALF/FULL DUPLEX
# MX8MQ_IOMUXC_NAND_DATA01_GPIO3_IO7      Serial READ ENABLE

# Get gpiochip2 bank lines
gpio9   = chip.get_line(9)  #RS485 EN
gpio8   = chip.get_line(8)  #Full Duplex
gpio7   = chip.get_line(7)  #Read Enable ACTIVE LOW
gpio22  = chip.get_line(12) #SLEW ALLOWS HIGHER BAUD RATES ABOVE 0.5M


# Create Output config
config_output = gpiod.line_request()
config_output.consumer = "RS485UART2"
config_output.request_type = gpiod.line_request.DIRECTION_OUTPUT

# Request Lines
gpio9   = chip.request(config_output, 0)
gpio8   = chip.request(config_output, 0)
gpio7   = chip.request(config_output, 0)
gpio22  = chip.request(config_output, 0)

# Set GPIO values
gpio9.set_value(1)  #RS485 ENABLE
gpio8.set_value(1)  #Full Duplex
gpio7.set_value(0)  #ACTIVE LOW READ ENABLE
gpio22.set_value(1) #ACTIVE HIGH SLEW ENABLE FOR HIGH BAUD RATE SPEEDS

# The rs485-config file now is 0 indexed to match kernel device indexing.
subprocess.call(['./rs485-config', '1'])

