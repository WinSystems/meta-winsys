FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://0001-Add-C444-device-tree.patch \
    file://0002-Enable-USB-and-LVDS-Bridge-drivers.patch \ 
    file://0003-Set-connector-and-BUS-format.patch \
    file://0004-Use-different-driver-to-fix-audio-issues.patch \
    file://0005-Fix-RS285-RST-active-low-issue.patch \
    file://0006-Enable-TPM.patch"