(function ($) {
    $.session = {
        _id: null,

        _cookieCache: undefined,


        _init: function () {
            this._id = 'sessionID';
            this._initCache();

            var matches = (new RegExp(this._generatePrefix() + "=([^;]+);")).exec(document.cookie);
            if (matches && document.location.protocol !== matches[1]) {
                this._clearSession();
                for (var key in this._cookieCache) {
                    try {
                        window.sessionStorage.setItem(key, this._cookieCache[key]);
                    } catch (e) {
                    }
                    ;
                }
            }

            document.cookie = this._generatePrefix() + "=" + document.location.protocol + ';path=/;expires=' + (new Date((new Date).getTime() + 28800000)).toUTCString(); // 鍔犱笂鍏釜灏忔椂=鍖椾含鏃堕棿

        },

        _generatePrefix: function () {
            return '__session:' + this._id + ':';
        },

        _initCache: function () {
            var cookies = document.cookie.split(';');
            this._cookieCache = {};
            for (var i in cookies) {
                var kv = cookies[i].split('=');
                if ((new RegExp(this._generatePrefix() + '.+')).test(kv[0]) && kv[1]) {
                    this._cookieCache[kv[0].split(':', 3)[2]] = kv[1];
                }
            }
        },

        _setFallback: function (key, value, num)//鍙傛暟鍒嗗埆鏄痵ession鐨刱ey銆侀敭鍊煎拰杩囨湡鏃堕棿锛屼互澶╀负鍗曚綅锛宯um=1鍗充负1澶╋紝涓嶄紶鎴栦紶鍏ラ潪鏁板瓧鍧囬粯璁や负1澶�
        {

            var cookie = this._generatePrefix() + key + "=" + value + ";path=/";
            if (!isNaN(num)) {
                cookie += ";expires=" + (new Date(Date.now() + (86400000 * Number(num)))).toUTCString();
            } else {
                console.log('!!!The third input value must be a number. Otherwise, it is set to 1 day by default.^_^');
                cookie += ";expires=" + (new Date(Date.now() + 86400000)).toUTCString();
            }
            document.cookie = cookie;
            this._cookieCache[key] = value;
            return this;
        },

        _getFallback: function (key) {
            if (!this._cookieCache) {
                this._initCache();
            }
            return this._cookieCache[key];
        },

        _clearFallback: function () {
            for (var i in this._cookieCache) {
                document.cookie = this._generatePrefix() + i + '=;path=/;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
            }
            this._cookieCache = {};
        },

        _deleteFallback: function (key) {
            document.cookie = this._generatePrefix() + key + '=;path=/;expires=Thu, 01 Jan 1970 00:00:01 GMT;'; // 鎶婃湁鏁堟椂闂磋缃负杩囨湡
            delete this._cookieCache[key];
        },

        get: function (key) {
            return window.sessionStorage.getItem(key) || this._getFallback(key);
        },

        set: function (key, value, onceOnly) {
            try {
                window.sessionStorage.setItem(key, value);
            } catch (e) {
            }
            this._setFallback(key, value, onceOnly || false);
            return this;
        },

        'delete': function (key) {
            return this.remove(key);
        },

        remove: function (key) {
            try {
                window.sessionStorage.removeItem(key);
            } catch (e) {
            }
            ;
            this._deleteFallback(key);
            return this;
        },

        _clearSession: function () {
            try {
                window.sessionStorage.clear();
            } catch (e) {
                for (var i in window.sessionStorage) {
                    window.sessionStorage.removeItem(i);
                }
            }
        },

        clear: function () {
            this._clearSession();
            this._clearFallback();
            return this;
        }

    };

    $.session._init();

})(jQuery);