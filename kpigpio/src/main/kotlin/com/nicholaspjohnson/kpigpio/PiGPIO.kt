package com.nicholaspjohnson.kpigpio

import com.nicholaspjohnson.kpigpio.exceptions.*

object PiGPIO {
    init {
        val javaLibraryPath = System.getProperty("java.library.path")
        if(!javaLibraryPath.contains("/usr/lib")) {
            System.setProperty("java.library.path", "$javaLibraryPath:/usr/lib")
        }
        System.loadLibrary("KPiGPIOC")
    }

    object Constants {
        const val PI_MIN_GPIO = 0
        const val PI_MAX_GPIO = 53

/* user_gpio: 0-31 */

        const val PI_MAX_USER_GPIO = 31

/* level: 0-1 */

        const val PI_OFF = 0
        const val PI_ON = 1

        const val PI_CLEAR = 0
        const val PI_SET = 1

        const val PI_LOW = 0
        const val PI_HIGH = 1

/* level: only reported for GPIO time-out, see gpioSetWatchdog */

        const val PI_TIMEOUT = 2

/* mode: 0-7 */

        const val PI_INPUT = 0
        const val PI_OUTPUT = 1
        const val PI_ALT0 = 4
        const val PI_ALT1 = 5
        const val PI_ALT2 = 6
        const val PI_ALT3 = 7
        const val PI_ALT4 = 3
        const val PI_ALT5 = 2

/* pud: 0-2 */

        const val PI_PUD_OFF = 0
        const val PI_PUD_DOWN = 1
        const val PI_PUD_UP = 2

/* dutycycle: 0-range */

        const val PI_DEFAULT_DUTYCYCLE_RANGE = 255

/* range: 25-40000 */

        const val PI_MIN_DUTYCYCLE_RANGE = 25
        const val PI_MAX_DUTYCYCLE_RANGE = 40000

/* pulsewidth: 0, 500-2500 */

        const val PI_SERVO_OFF = 0
        const val PI_MIN_SERVO_PULSEWIDTH = 500
        const val PI_MAX_SERVO_PULSEWIDTH = 2500

/* hardware PWM */

        const val PI_HW_PWM_MIN_FREQ = 1
        const val PI_HW_PWM_MAX_FREQ = 125000000
        const val PI_HW_PWM_MAX_FREQ_2711 = 187500000
        const val PI_HW_PWM_RANGE = 1000000

/* hardware clock */

        const val PI_HW_CLK_MIN_FREQ = 4689
        const val PI_HW_CLK_MIN_FREQ_2711 = 13184
        const val PI_HW_CLK_MAX_FREQ = 250000000
        const val PI_HW_CLK_MAX_FREQ_2711 = 375000000

        const val PI_NOTIFY_SLOTS = 32

        const val PI_NTFY_FLAGS_EVENT = (1 shl 7)
        const val PI_NTFY_FLAGS_ALIVE = (1 shl 6)
        const val PI_NTFY_FLAGS_WDOG = (1 shl 5)
        fun PI_NTFY_FLAGS_BIT(x: Int) = (((x) shl 0) and 31)

        const val PI_WAVE_BLOCKS = 4
        const val PI_WAVE_MAX_PULSES = (PI_WAVE_BLOCKS * 3000)
        const val PI_WAVE_MAX_CHARS = (PI_WAVE_BLOCKS *  300)

        const val PI_BB_I2C_MIN_BAUD = 50
        const val PI_BB_I2C_MAX_BAUD = 500000

        const val PI_BB_SPI_MIN_BAUD = 50
        const val PI_BB_SPI_MAX_BAUD = 250000

        const val PI_BB_SER_MIN_BAUD = 50
        const val PI_BB_SER_MAX_BAUD = 250000

        const val PI_BB_SER_NORMAL = 0
        const val PI_BB_SER_INVERT = 1

        const val PI_WAVE_MIN_BAUD = 50
        const val PI_WAVE_MAX_BAUD = 1000000

        const val PI_SPI_MIN_BAUD = 32000
        const val PI_SPI_MAX_BAUD = 125000000

        const val PI_MIN_WAVE_DATABITS = 1
        const val PI_MAX_WAVE_DATABITS = 32

        const val PI_MIN_WAVE_HALFSTOPBITS = 2
        const val PI_MAX_WAVE_HALFSTOPBITS = 8

        const val PI_WAVE_MAX_MICROS = (30 * 60 * 1000000) /* half an hour */

        const val PI_MAX_WAVES = 250

        const val PI_MAX_WAVE_CYCLES = 65535
        const val PI_MAX_WAVE_DELAY = 65535

        const val PI_WAVE_COUNT_PAGES = 10

/* wave tx mode */

        const val PI_WAVE_MODE_ONE_SHOT = 0
        const val PI_WAVE_MODE_REPEAT = 1
        const val PI_WAVE_MODE_ONE_SHOT_SYNC = 2
        const val PI_WAVE_MODE_REPEAT_SYNC = 3

/* special wave at return values */

        const val PI_WAVE_NOT_FOUND = 9998 /* Transmitted wave not found. */
        const val PI_NO_TX_WAVE = 9999 /* No wave being transmitted. */

/* Files, I2C, SPI, SER */

        const val PI_FILE_SLOTS = 16
        const val PI_I2C_SLOTS = 64
        const val PI_SPI_SLOTS = 32
        const val PI_SER_SLOTS = 16

        const val PI_MAX_I2C_ADDR = 0x7F

        const val PI_NUM_AUX_SPI_CHANNEL = 3
        const val PI_NUM_STD_SPI_CHANNEL = 2

        const val PI_MAX_I2C_DEVICE_COUNT = (1 shl 16)
        const val PI_MAX_SPI_DEVICE_COUNT = (1 shl 16)

/* max pi_i2c_msg_t per transaction */

        const val PI_I2C_RDRW_IOCTL_MAX_MSGS = 42

/* flags for i2cTransaction, pi_i2c_msg_t */

        const val PI_I2C_M_WR = 0x0000 /* write data */
        const val PI_I2C_M_RD = 0x0001 /* read data */
        const val PI_I2C_M_TEN = 0x0010 /* ten bit chip address */
        const val PI_I2C_M_RECV_LEN = 0x0400 /* length will be first received byte */
        const val PI_I2C_M_NO_RD_ACK = 0x0800 /* if I2C_FUNC_PROTOCOL_MANGLING */
        const val PI_I2C_M_IGNORE_NAK = 0x1000 /* if I2C_FUNC_PROTOCOL_MANGLING */
        const val PI_I2C_M_REV_DIR_ADDR = 0x2000 /* if I2C_FUNC_PROTOCOL_MANGLING */
        const val PI_I2C_M_NOSTART = 0x4000 /* if I2C_FUNC_PROTOCOL_MANGLING */

/* bbI2CZip and i2cZip commands */

        const val PI_I2C_END = 0
        const val PI_I2C_ESC = 1
        const val PI_I2C_START = 2
        const val PI_I2C_COMBINED_ON = 2
        const val PI_I2C_STOP = 3
        const val PI_I2C_COMBINED_OFF = 3
        const val PI_I2C_ADDR = 4
        const val PI_I2C_FLAGS = 5
        const val PI_I2C_READ = 6
        const val PI_I2C_WRITE = 7

/* SPI */

        fun PI_SPI_FLAGS_BITLEN(x: Int) =  ((x and 63) shl 16)
        fun PI_SPI_FLAGS_RX_LSB(x: Int) =   ((x and 1) shl 15)
        fun PI_SPI_FLAGS_TX_LSB(x: Int) =   ((x and 1) shl 14)
        fun PI_SPI_FLAGS_3WREN(x: Int) =   ((x and 15) shl 10)
        fun PI_SPI_FLAGS_3WIRE(x: Int) =    ((x and 1) shl 9)
        fun PI_SPI_FLAGS_AUX_SPI(x: Int) =  ((x and 1) shl 8)
        fun PI_SPI_FLAGS_RESVD(x: Int) =    ((x and 7) shl 5)
        fun PI_SPI_FLAGS_CSPOLS(x: Int) =   ((x and 7) shl 2)
        fun PI_SPI_FLAGS_MODE(x: Int) =     ((x and 3))

/* BSC registers */

        const val BSC_DR = 0
        const val BSC_RSR = 1
        const val BSC_SLV = 2
        const val BSC_CR = 3
        const val BSC_FR = 4
        const val BSC_IFLS = 5
        const val BSC_IMSC = 6
        const val BSC_RIS = 7
        const val BSC_MIS = 8
        const val BSC_ICR = 9
        const val BSC_DMACR = 10
        const val BSC_TDR = 11
        const val BSC_GPUSTAT = 12
        const val BSC_HCTRL = 13
        const val BSC_DEBUG_I2C = 14
        const val BSC_DEBUG_SPI = 15

        const val BSC_CR_TESTFIFO = 2048
        const val BSC_CR_RXE = 512
        const val BSC_CR_TXE = 256
        const val BSC_CR_BRK = 128
        const val BSC_CR_CPOL = 16
        const val BSC_CR_CPHA = 8
        const val BSC_CR_I2C = 4
        const val BSC_CR_SPI = 2
        const val BSC_CR_EN = 1

        const val BSC_FR_RXBUSY = 32
        const val BSC_FR_TXFE = 16
        const val BSC_FR_RXFF = 8
        const val BSC_FR_TXFF = 4
        const val BSC_FR_RXFE = 2
        const val BSC_FR_TXBUSY = 1

/* BSC GPIO */

        const val BSC_SDA_MOSI = 18
        const val BSC_SCL_SCLK = 19
        const val BSC_MISO = 20
        const val BSC_CE_N = 21

/* Longest busy delay */

        const val PI_MAX_BUSY_DELAY = 100

/* timeout: 0-60000 */

        const val PI_MIN_WDOG_TIMEOUT = 0
        const val PI_MAX_WDOG_TIMEOUT = 60000

/* timer: 0-9 */

        const val PI_MIN_TIMER = 0
        const val PI_MAX_TIMER = 9

/* millis: 10-60000 */

        const val PI_MIN_MS = 10
        const val PI_MAX_MS = 60000

        const val PI_MAX_SCRIPTS = 32

        const val PI_MAX_SCRIPT_TAGS = 50
        const val PI_MAX_SCRIPT_VARS = 150
        const val PI_MAX_SCRIPT_PARAMS = 10

/* script status */

        const val PI_SCRIPT_INITING = 0
        const val PI_SCRIPT_HALTED = 1
        const val PI_SCRIPT_RUNNING = 2
        const val PI_SCRIPT_WAITING = 3
        const val PI_SCRIPT_FAILED = 4

/* signum: 0-63 */

        const val PI_MIN_SIGNUM = 0
        const val PI_MAX_SIGNUM = 63

/* timetype: 0-1 */

        const val PI_TIME_RELATIVE = 0
        const val PI_TIME_ABSOLUTE = 1

        const val PI_MAX_MICS_DELAY = 1000000 /* 1 second */
        const val PI_MAX_MILS_DELAY = 60000   /* 60 seconds */

/* cfgMillis */

        const val PI_BUF_MILLIS_MIN = 100
        const val PI_BUF_MILLIS_MAX = 10000

/* cfgMicros: 1, 2, 4, 5, 8, or 10 */

/* cfgPeripheral: 0-1 */

        const val PI_CLOCK_PWM = 0
        const val PI_CLOCK_PCM = 1

/* DMA channel: 0-15, 15 is unset */

        const val PI_MIN_DMA_CHANNEL = 0
        const val PI_MAX_DMA_CHANNEL = 15

/* port */

        const val PI_MIN_SOCKET_PORT = 1024
        const val PI_MAX_SOCKET_PORT = 32000


/* ifFlags: */

        const val PI_DISABLE_FIFO_IF = 1
        const val PI_DISABLE_SOCK_IF = 2
        const val PI_LOCALHOST_SOCK_IF = 4
        const val PI_DISABLE_ALERT = 8

/* memAllocMode */

        const val PI_MEM_ALLOC_AUTO = 0
        const val PI_MEM_ALLOC_PAGEMAP = 1
        const val PI_MEM_ALLOC_MAILBOX = 2

/* filters */

        const val PI_MAX_STEADY = 300000
        const val PI_MAX_ACTIVE = 1000000

/* gpioCfgInternals */

        const val PI_CFG_DBG_LEVEL = 0 /* bits 0-3 */
        const val PI_CFG_ALERT_FREQ = 4 /* bits 4-7 */
        const val PI_CFG_RT_PRIORITY = (1 shl 8)
        const val PI_CFG_STATS = (1 shl 9)
        const val PI_CFG_NOSIGHANDLER = (1 shl 10)

        const val PI_CFG_ILLEGAL_VAL = (1 shl 11)


/* gpioISR */

        const val RISING_EDGE = 0
        const val FALLING_EDGE = 1
        const val EITHER_EDGE = 2


/* pads */

        const val PI_MAX_PAD = 2

        const val PI_MIN_PAD_STRENGTH = 1
        const val PI_MAX_PAD_STRENGTH = 16

/* files */

        const val PI_FILE_NONE = 0
        const val PI_FILE_MIN = 1
        const val PI_FILE_READ = 1
        const val PI_FILE_WRITE = 2
        const val PI_FILE_RW = 3
        const val PI_FILE_APPEND = 4
        const val PI_FILE_CREATE = 8
        const val PI_FILE_TRUNC = 16
        const val PI_FILE_MAX = 31

        const val PI_FROM_START = 0
        const val PI_FROM_CURRENT = 1
        const val PI_FROM_END = 2

/* Allowed socket connect addresses */

        const val MAX_CONNECT_ADDRESSES = 256

/* events */

        const val PI_MAX_EVENT = 31

/* Event auto generated on BSC slave activity */

        const val PI_EVENT_BSC = 31


    }

    @Throws(GPIOInitFailedException::class)
    external fun gpioInitialize(): Int
    external fun gpioTerminate()

    @Throws(GPIOBadGPIOException::class, GPIOBadModeException::class)
    external fun gpioSetMode(gpio: Int, mode: Int)
    @Throws(GPIOBadGPIOException::class)
    external fun gpioGetMode(gpio: Int): Int

    @Throws(GPIOBadGPIOException::class, GPIOBadPUDException::class)
    external fun gpioSetPullUpDown(gpio: Int, pud: Int)

    @Throws(GPIOBadGPIOException::class)
    external fun gpioRead(gpio: Int): Int
    @Throws(GPIOBadGPIOException::class, GPIOBadLevelException::class)
    external fun gpioWrite(gpio: Int, level: Int)

    @Throws(GPIOBadUserGPIOException::class, GPIOBadDutycycleException::class)
    external fun gpioPWM(userGPIO: Int, dutycycle: Int)
    @Throws(GPIOBadUserGPIOException::class, GPIONotPWMGPIOException::class)
    external fun gpioGetPWMdutycycle(userGPIO: Int): Int

    @Throws(GPIOBadUserGPIOException::class, GPIOBadDutyrangeException::class)
    external fun gpioSetPWMrange(userGPIO: Int, range: Int): Int
    @Throws(GPIOBadUserGPIOException::class)
    external fun gpioGetPWMrange(userGPIO: Int): Int
    @Throws(GPIOBadUserGPIOException::class)
    external fun gpioGetPWMrealRange(userGPIO: Int): Int

    @Throws(GPIOBadUserGPIOException::class)
    external fun gpioSetPWMfrequency(userGPIO: Int, frequency: Int): Int
    @Throws(GPIOBadUserGPIOException::class)
    external fun gpioGetPWMfrequency(userGPIO: Int): Int


    external fun gpioCfgSetInternals(cfgVal: Int): Int
}