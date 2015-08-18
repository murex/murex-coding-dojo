def combine(list)
  custom_sort = ->(a,b) { compare(a,b) }
  list.sort(& custom_sort).join("")
end
def compare (a,b)
  if (a.to_s + b.to_s > b.to_s + a.to_s)
    return a<=>b
  else
    return b<=>a
  end
end