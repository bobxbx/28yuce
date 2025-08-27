local key = KEYS[1]
local interval = tonumber(ARGV[1])

-- 检查 rate 是否存在且为有效数字
local rate = redis.call('HGET', key, 'rate')
if not rate then
    return nil
end

local numeric_rate = tonumber(rate)
if not numeric_rate then
    return nil
end

-- 执行安全计算
local increment = numeric_rate * interval
redis.call('HINCRBYFLOAT', key, 'balance', increment)
return nil