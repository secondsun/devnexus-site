class Speakers
  attr_accessor :data
  def initialize(img_host="https://cfp.devnexus.com")
      @img_host = img_host
      @data = {}
  end
  def full_path_avatar(person)
      img_path = person['avatar_path']
      person['avatar_path'] = "#{@img_host}#{img_path}"
      return person
  end
  def count()
    return @data.size()
  end
  # speakers are nested under each event as people,
  # create a new collection of people, and associate each events id to the
  # people in that event.  This does not de-dup people.
  def people_from_events(event_arr)
     all_people = event_arr.collect do |e|
         e['people'].collect do |sp| sp.merge({ "events" => [ e["id"]] }) end
     end
     return all_people.flatten
  end
  # take an array of people and de-dup, keeping all events
  def organize_people(people_arr, person_data = {})
      return people_arr.each_with_object(person_data) do | person, personDB |
        pid = person.delete("id")
        p_data = personDB.fetch(pid, person)  #defaults to this person
        p_data["events"] = p_data["events"] | person["events"]
        personDB[pid] = p_data
      end
  end
  def collect_people_events(event_arr)
     event_people = people_from_events(event_arr)
     organize_people(event_people, @data)
  end
end
