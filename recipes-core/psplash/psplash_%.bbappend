FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " file://0001-Set-background-color-to-blue.patch "

PACKAGECONFIG:remove = "progress-bar"
