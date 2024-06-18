import subprocess
import gpiod
import sys
import time

subprocess.call(['dmesg', '-n', '1'])
subprocess.call(['systemctl', 'stop', 'serial-getty@ttymxc0.service'])

# GPIO Banks are 0 indexed by the kernel: GPIO1 is Bank/gpiochip0
chip=gpiod.chip('gpiochip2')

# These are the GPIO lines connected to the UART1 transciever.
# MX8MQ_IOMUXC_NAND_CE2_B_GPIO3_IO3     Serial SHDN
# MX8MQ_IOMUXC_NAND_CE3_B_GPIO3_IO4     Serial SLEW
# MX8MQ_IOMUXC_NAND_DQS_GPIO3_IO14      Serial FD_TX
# MX8MQ_IOMUXC_NAND_RE_B_GPIO3_IO15     Serial TERM
# MX8MQ_IOMUXC_NAND_READY_B_GPIO3_IO16  Serial MODE
# MX8MQ_IOMUXC_NAND_WE_B_GPIO3_IO17     Serial HALF/FULL DUPLEX
# MX8MQ_IOMUXC_NAND_WP_B_GPIO3_IO18     Serial READ ENABLE

# Get gpiochip0 bank lines
gpio16 = chip.get_line(16) #RS485 EN
gpio17 = chip.get_line(17) #Full Duplex
gpio18 = chip.get_line(18) #Read Enable ACTIVE LOW
gpio4  = chip.get_line(4)  #SLEW ALLOWS HIGHER BAUD RATES ABOVE 0.5M
gpio15  = chip.get_line(15)  #TERM

# Create Output config
config_output = gpiod.line_request()
config_output.consumer = "RS485UART1"
config_output.request_type = gpiod.line_request.DIRECTION_OUTPUT

# Request Lines
gpio16.request(config_output, 0)
gpio17.request(config_output, 0)
gpio18.request(config_output, 0)
gpio4.request(config_output, 0)
gpio15.request(config_output, 0)

#Set GPIO values
gpio16.set_value(1) #RS485 ENABLE
gpio17.set_value(0) #Full Duplex
gpio18.set_value(0) #ACTIVE LOW READ ENABLE
gpio4.set_value(0)  #ACTIVE HIGH SLEW ENABLE FOR HIGH BAUD RATE SPEEDS
gpio15.set_value(1) #ACTIVE HIGH ENABLE TERMINATION RESISTORS

# The rs485-config file now is 0 indexed to match kernel device indexing.
subprocess.call(['./rs485-config', '0'])
