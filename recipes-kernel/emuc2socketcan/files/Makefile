CFILES           := main.c emuc_parse.c transceive.c
TARGET           := emuc2socketcan.ko
obj-m            := emuc2socketcan.o
INCLUDE_DIR      ?= $(PWD)/include
SRC              := $(shell pwd)
emuc2socketcan-y := $(CFILES:.c=.o)
ccflags-y        := -I$(INCLUDE_DIR) -std=gnu99 -Wno-declaration-after-statement
ccflags-y        += -D_DBG_FUNC=0 -D_DBG_RECV_HEX=0 -D_DBG_BUMP=0


.PHONY: modules modules_install modules_clean

all: modules

install: modules_install

clean:
        rm -f *.o *~ core .depend .*.cmd *.ko *.mod.c
        rm -f Module.markers Module.symvers modules.order
        rm -rf .tmp_versions Modules.symvers

modules:
        $(MAKE) -C $(KERNEL_SRC) M=$(SRC) modules
modules_install: modules
        $(MAKE) -C $(KERNEL_SRC) M=$(SRC) modules_install
modules_clean:
        $(MAKE) -C $(KERNEL_SRC) M=$(SRC) clean

