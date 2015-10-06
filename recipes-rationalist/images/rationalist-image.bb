SUMMARY = "A small image just capable of allowing a device to boot."

RATIONALIST_PKGS = "\
 avahi-daemon\
 expat\
 initscripts\
 iproute2\
 iproute2-bridge\
 iproute2-tc\
 iptables\
 jittertrap\
 jittertrap-dbg\
 kernel-modules\
 kmod\
 netbase\
 openssh\
 packagegroup-core-boot\
 run-postinsts\
 shadow\
 shadow-securetty\
 systemd\
 systemd-compat-units\
 systemd-serialgetty\
 tcpdump\
 update-alternatives-opkg\
 update-rc.d\
 util-linux-agetty\
 util-linux-libblkid\
 util-linux-libmount\
 util-linux-libuuid\
 util-linux-mount\
"

DEPENDS = "parted-native"

DEVEL_PKGS = "ethtool gdb latencytop valgrind"

CONFIG_PKGS = "mousetrap"

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL} ${RATIONALIST_PKGS} ${CONFIG_PKGS} ${DEVEL_PKGS}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

IMAGE_FEATURES += "package-management"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

set_root_password() {
}

add_custom_smart_config() {
	smart --data-dir=${IMAGE_ROOTFS}/var/lib/smart\
		channel -y --add mousetrap_hw \
		type=rpm-md\
		name="Jittertrap mousetrap_hw Package Repository"\
		baseurl=http://testing.jittertrap.com/mousetrap/rpm/mousetrap_hw

	smart --data-dir=${IMAGE_ROOTFS}/var/lib/smart\
		channel -y --add all \
		type=rpm-md\
		name="Jittertrap all hw Package Repository"\
		baseurl=http://testing.jittertrap.com/mousetrap/rpm/all

	smart --data-dir=${IMAGE_ROOTFS}/var/lib/smart\
		channel -y --add core2_32 \
		type=rpm-md\
		name="Jittertrap core2_32 Package Repository"\
		baseurl=http://testing.jittertrap.com/mousetrap/rpm/core2_32
}



ROOTFS_POSTPROCESS_COMMAND =+ "set_root_password ; add_custom_smart_config ;"
