import gpiod
import sys
import time

class bcolors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKCYAN = '\033[96m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'

def main():
    # Get GPIO0 Bank/gpiochip0
    chip=gpiod.chip('gpiochip0')
    
    # Get gpiochip0 bank lines
    gpio0 = chip.get_line(0)
    gpio1 = chip.get_line(1)
    gpio2 = chip.get_line(3)
    gpio3 = chip.get_line(5)
    gpio4 = chip.get_line(6)
    gpio5 = chip.get_line(7)

    # Create Output config
    config_output = gpiod.line_request()
    config_output.consumer = "GPIO TEST 1"
    config_output.request_type = gpiod.line_request.DIRECTION_OUTPUT

    # Create Input config
    config_input = gpiod.line_request()
    config_input.consumer = "GPIO TEST 2"
    config_input.request_type = gpiod.line_request.DIRECTION_INPUT

    # Request GPIO to kernel
    gpio0.request(config_output, 0)
    gpio1.request(config_output, 0)
    gpio2.request(config_output, 0)
    gpio3.request(config_input, 0)
    gpio4.request(config_input, 0)
    gpio5.request(config_input, 0)

    # Create loopback pairs
    loopback_pairs = [
        [[gpio0, 'gpio0'], [gpio3, 'gpio3']],
        [[gpio1, 'gpio1'], [gpio4, 'gpio4']],
        [[gpio2, 'gpio2'], [gpio5, 'gpio5']],
    ]

    okay_str = (bcolors.OKGREEN + 'Okay' + bcolors.ENDC)
    fail_str = (bcolors.FAIL + 'Fail' + bcolors.ENDC)
    print("Testing GPIO[0, 1, 2] WRITE | GPIO[3, 4, 5] READ")
    for pair in loopback_pairs:
        print("Set {0} OUTPUT | Set {1} INPUT".format(pair[0][1], pair[1][1]))
        # Set first pair as output
        pair[0][0].set_direction_output()
        # Set second pair as input
        pair[1][0].set_direction_input()

    for pair in loopback_pairs:
        pair[0][0].set_value(1)
        time.sleep(0.004)
        print("TEST {0}: WRITE 1 | {1}: READ | STATUS: {2}".format(pair[0][1], pair[1][1], 
            (okay_str) if (pair[1][0].get_value()==1) else "{0} {1}".format(fail_str, pair[1][0].get_value())))
        pair[0][0].set_value(0)
        time.sleep(0.004)
        print("TEST {0}: WRITE 0 | {1}: READ | STATUS: {2}".format(pair[0][1], pair[1][1], 
            (okay_str) if (pair[1][0].get_value()==0) else "{0} {1}".format(fail_str, pair[1][0].get_value())))
    
    print("Testing GPIO[0, 1, 2] READ | GPIO[3, 4, 5] WRITE")
    for pair in loopback_pairs:
        print("Set {0} OUTPUT | Set {1} INPUT".format(pair[0][1], pair[1][1]))
        #Set first pair as input
        pair[0][0].set_direction_input()
        #Set second pair as output
        pair[1][0].set_direction_output()

    for pair in loopback_pairs:
        pair[1][0].set_value(1)
        time.sleep(0.004)
        print("TEST {0}: WRITE 1 | {1}: READ | STATUS: {2}".format(pair[1][1], pair[0][1], 
            (okay_str) if (pair[0][0].get_value()==1) else "{0} {1}".format(fail_str, pair[1][0].get_value())))
        pair[1][0].set_value(0)
        time.sleep(0.004)
        print("TEST {0}: WRITE 0 | {1}: READ | STATUS: {2}".format(pair[1][1], pair[0][1], 
            (okay_str) if (pair[0][0].get_value()==0) else "{0} {1}".format(fail_str, pair[0][0].get_value())))

main()