
SUMMARY = "Python bindings for Linux SPI access through spidev"
HOMEPAGE = "http://github.com/doceme/py-spidev"
AUTHOR = "Volker Thoms <unconnected@gmx.de>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2077511c543a7c85245a516c47f4de78"

SRC_URI = "https://files.pythonhosted.org/packages/c7/d9/401c0a7be089e02826cf2c201f489876b601f15be100fe391ef9c2faed83/spidev-3.6.tar.gz"
SRC_URI[md5sum] = "83a73279d6e823a9030c4315577bfae3"
SRC_URI[sha256sum] = "14dbc37594a4aaef85403ab617985d3c3ef464d62bc9b769ef552db53701115b"

S = "${WORKDIR}/spidev-3.6"

RDEPENDS_${PN} = ""

inherit setuptools3
