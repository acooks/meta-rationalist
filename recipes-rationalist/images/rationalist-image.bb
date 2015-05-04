SUMMARY = "A small image just capable of allowing a device to boot."

RATIONALIST_PKGS = "\
 avahi-daemon\
 ethtool\
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
 libacl\
 libattr\
 libcap\
 libcomerr\
 libe2p\
 libext2fs\
 libgcc\
 libkmod\
 liblzma\
 libwrap\
 libx11\
 libxau\
 libxcb\
 libxdmcp\
 netbase\
 openssh\
 packagegroup-core-boot\
 pciutils\
 ppp\
 ppp-oa\
 ppp-oe\
 ppp-tools\
 run-postinsts\
 shadow\
 shadow-securetty\
 systemd\
 systemd-binfmt\
 systemd-compat-units\
 systemd-serialgetty\
 tcpdump\
 update-alternatives-opkg\
 update-rc.d\
 util-linux-agetty\
 util-linux-fsck\
 util-linux-libblkid\
 util-linux-libmount\
 util-linux-libuuid\
 util-linux-mount\
 zlib\
"

CONFIG_PKGS = "mousetrap"
#CONFIG_PKGS = ""

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL} ${RATIONALIST_PKGS} ${CONFIG_PKGS}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"


