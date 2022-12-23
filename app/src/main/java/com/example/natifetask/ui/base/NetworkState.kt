package com.example.natifetask.ui.base

data class NetworkState<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T): NetworkState<T> =
            NetworkState(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): NetworkState<T> =
            NetworkState(status = Status.ERROR, data = data, message = message)

        fun <T> loading(data: T?): NetworkState<T> =
            NetworkState(status = Status.LOADING, data = data, message = null)
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }
}