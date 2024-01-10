/*
 * Copyright (c) 2016 WinSystems, Inc.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

#include <linux/serial.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/ioctl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* Driver-specific ioctls: */
#define TIOCGRS485      0x542E
#define TIOCSRS485      0x542F

int main(int argc, char *argv[])
{
    struct serial_rs485 rs485conf;
    int uart_num, fd_uart;

    // check for two arguments or 3 arguments
    if (argc != 2) {
        printf("A single uart from 0-1 must be specified\n");
        printf("Specify nostdout as second option to block printf output\n");
        printf("Usage: rs485-config <uart num>\n");
        exit(1);
    }

    uart_num = atoi(argv[1]);

    // check uart range
    if (uart_num < 0 || uart_num > 1) {
        printf("A valid uart from 0-1 must be specified\n");
        printf("Usage: rs485-config <uart num>\n");
        exit(1);
    }

    if(argc != 3)
    {
        printf("Enable rs485 mode for uart%d (ttymxc%d) ... ", uart_num, uart_num);
    }

    // initialize rs485 struct
    memset(&rs485conf, 0, sizeof(rs485conf));

    if (uart_num == 0)
        fd_uart = open("/dev/ttymxc0", O_RDWR); // open uart1
    else if (uart_num == 1)
        fd_uart = open("/dev/ttymxc1", O_RDWR); // open uart2

    if (fd_uart < 0) {
        if(argc != 3)
        {
            printf("uart cannot be opened (fd = %d)\n", fd_uart);
        }
        exit(1);
    }   

    // set RS485 mode
    rs485conf.flags |= SER_RS485_ENABLED;
    rs485conf.flags |= SER_RS485_RTS_ON_SEND;
    //rs485conf.flags |= SER_RS485_RTS_AFTER_SEND;
    //rs485conf.flags |= SER_RS485_RX_DURING_TX;
    if (ioctl(fd_uart, TIOCSRS485, &rs485conf) < 0) {
        if(argc != 3)
        {
            printf("rs485 cannot be enabled\n");
        }
        exit(1);
    }

    // close uart
    if (close(fd_uart) < 0) {
        if(argc != 3)
        {
            printf("uart cannot be closed\n");
        }
        exit(1);
    }

    printf("complete!\n", uart_num);
}
