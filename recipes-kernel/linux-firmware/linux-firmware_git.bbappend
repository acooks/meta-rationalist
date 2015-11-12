LICENSE_${PN}-rtl8168 = "Firmware-RTL-NIC"

LIC_FILES_CHKSUM_${PN}-rtl8168 = "\
    file://WHENCE;md5=e896f2f5d42bb996b9213261bcb815ae"

# Set NO_GENERIC_LICENSE so that the license file will be copied from
# fetched source
NO_GENERIC_LICENSE[Firmware-RTL-NIC] = "WHENCE"


PACKAGES += "${PN}-rtl8168"
PROVIDES += "${PN}-rtl8168"
RPROVIDES_${PN} += "${PN}-rtl8168"

FILES_${PN}-rtl8168 = "/lib/firmware/rtl_nic/rtl8168*.fw \
	/lib/firmware/WHENCE"

do_install_append() {
	cd ${S}
	install -d  ${D}/lib/firmware/rtl_nic/

	# Realtek 8168 NIC
	install -m 0666 ${S}/rtl_nic/rtl8168*.fw ${D}/lib/firmware/rtl_nic/
	install -m 0666 ${S}/WHENCE ${D}/lib/firmware/
}


