
SUMMARY = "XMODEM protocol implementation."
HOMEPAGE = "https://github.com/tehmaze/xmodem"
AUTHOR = "Wijnand Modderman, Jeff Quast, Kris Hardy <maze@pyth0n.org>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=90bc9522130d68de0dcbf33707bbf124"

SRC_URI = "https://files.pythonhosted.org/packages/3d/17/fd6668a09afdc46c22990172b6f65e07dfb5bcf38960d063a7a887ca926d/xmodem-0.4.7.tar.gz"
SRC_URI[md5sum] = "0a21c269cb4d3995d13a2615c24fed0a"
SRC_URI[sha256sum] = "2f1068aa8676f0d1d112498b5786c4f8ea4f89d8f25d07d3a0f293cd21db1c35"

S = "${WORKDIR}/xmodem-0.4.7"

RDEPENDS_${PN} = ""
FILES:${PN} = " /usr/doc/XMODEM.TXT \
  /usr/doc/ymodem.txt \
  /usr/doc/XMODMCRC.TXT \
  /usr/doc/XMODEM1K.TXT"
inherit setuptools3
