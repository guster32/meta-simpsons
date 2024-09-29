SUMMARY = "Setup konami simpsons rom"
SECTION = "emulators"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

# file://simpsons.zip;unpack=false
SRC_URI = "file://enable-simpsons.service \
    file://simpsons.service \
    file://default.cfg \
    file://simpsons.cfg \
    file://mame.ini \
    file://ui.ini"
S = "${WORKDIR}"

inherit allarch systemd

do_install() {
	install -d ${D}/root/
    
    install -d ${D}/root/roms/
    #install -m 0644 ${S}/simpsons.zip ${D}/root/roms/simpsons.zip

    install -m 0644 ${S}/mame.ini ${D}/root/mame.ini
    install -m 0644 ${S}/ui.ini ${D}/root/ui.ini

    install -d ${D}/root/cfg/
    install -m 0644 ${S}/default.cfg ${D}/root/cfg/default.cfg
    install -m 0644 ${S}/simpsons.cfg ${D}/root/cfg/simpsons.cfg

    # Install the systemd --user service file for the user session
    install -d ${D}/usr/lib/systemd/user/
    install -m 0644 ${S}/simpsons.service ${D}/usr/lib/systemd/user/simpsons.service

    # Install the system-wide service to enable the user service
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/enable-simpsons.service ${D}${systemd_system_unitdir}/enable-simpsons.service
}

SYSTEMD_SERVICE:${PN} = "enable-simpsons.service"
SYSTEMD_AUTO_ENABLE = "enable"

FILES:${PN} += "/usr/lib/systemd/user/simpsons.service /usr/lib/systemd/system/enable-simpsons.service"
FILES:${PN} += "/root /root/mame.ini /root/ui.ini /root/roms /root/cfg /root/cfg/default.cfg /root/cfg/simpsons.cfg"

