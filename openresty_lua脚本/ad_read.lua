ngx.header.content_type="application/json;charset=utf8"
local uri_args = ngx.req.get_uri_args();
local position = uri_args["position"];
local cache_ngx = ngx.shared.dis_cache;
local adCache = cache_ngx:get('ad_cache_'..position);
if adCache == "" or adCache == nil then
	local redis = require("resty.redis");
	local red = redis:new()
	red:set_timeout(2000)
	local ok, err = red:connect("", 6379)
	local rescontent=red:get("ad_"..position)
	ngx.say(rescontent)
	red:close()
	cache_ngx:set('ad_cache_'..position, rescontent, 10*60);
else
	ngx.say(adCache)
end