SUMMARY = "Config for BufferUpr using PC Engines APU2."
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

RDEPENDS_${PN} = "initscripts apu2-serial-number"
PR = "r0"
COMPATIBLE_MACHINE = "pcengines-apu2"
RPROVIDES_${PN} = "trap-machine-config"

RRECOMMENDS_${PN}-dev += "valgrind gdb latencytop ethtool"

SRC_URI = "file://COPYING.GPL \
           file://systemd/network/br0.netdev \
           file://systemd/network/100-mgmt.link \
           file://systemd/network/101-port1.link \
           file://systemd/network/102-port2.link \
           file://systemd/network/br0.network \
           file://systemd/network/port1.network \
           file://systemd/network/port2.network \
           file://systemd/network/mgmt.network"

CONFFILES_${PN} += "${sysconfdir}/systemd/system/serial-getty@ttyS0.service"

do_configure () {
	cp ${WORKDIR}/COPYING.GPL ${S}/COPYING
}

do_install () {
	install -d ${D}${sysconfdir}/systemd/network
	install -m 644 ${WORKDIR}/systemd/network/* ${D}${sysconfdir}/systemd/network/

}

